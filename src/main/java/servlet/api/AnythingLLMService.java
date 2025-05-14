package servlet.api;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.json.*;


public class AnythingLLMService {
    private static final String API_KEY = "6Y049SJ-5HGMKEK-PCB8XZ0-4YFJ2MH";
    private static final String BASE_URL = "http://localhost:3001";

    public JSONArray fetchWorkspaces() throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet get = new HttpGet(BASE_URL + "/api/v1/workspaces");
            get.setHeader("Authorization", "Bearer " + API_KEY);

            String responseBody = EntityUtils.toString(client.execute(get).getEntity());
            JSONObject json = new JSONObject(responseBody);

            if (json.has("message")) {
                throw new RuntimeException("API 错误: " + json.getString("message"));
            }
            return json.getJSONArray("workspaces");
        }
    }

    public JSONObject chat(String workspaceSlug, String message) throws Exception {
        JSONObject payload = new JSONObject();
        payload.put("message", message);
        payload.put("mode", "chat");

        HttpPost post = new HttpPost(BASE_URL + "/api/v1/workspace/" + workspaceSlug + "/chat");
        post.setHeader("Authorization", "Bearer " + API_KEY);
        post.setHeader("Content-Type", "application/json");
        post.setEntity(new StringEntity(payload.toString(), "UTF-8"));

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpResponse response = client.execute(post);
            String responseBody = EntityUtils.toString(response.getEntity());

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("API 错误: " + responseBody);
            }
            return new JSONObject(responseBody);
        }
    }
}