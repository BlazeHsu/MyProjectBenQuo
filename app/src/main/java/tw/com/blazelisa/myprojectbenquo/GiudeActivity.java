package tw.com.blazelisa.myprojectbenquo;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import tw.com.blazelisa.myprojectbenquo.adapter.RecycleAdapter;
import tw.com.blazelisa.myprojectbenquo.bean.Glid;
import tw.com.blazelisa.myprojectbenquo.config.Config;

public class GiudeActivity extends AppCompatActivity {
    private TextView gide_tv ;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecycleAdapter recycleAdapter;
    private List<Glid> list = new ArrayList<>();
    private String url = Config._URL+"getinfo.php";
    RecyclerView.LayoutManager manager;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giude);
//        gide_tv = findViewById(R.id.giude_tv);
//        gide_tv.setText("GuideActivity");
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recycle_view_giude);
        manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        requestQueue = Volley.newRequestQueue(this.getApplicationContext());



        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count = 0;
                while(count < response.length()){
                    try {
                        JSONObject object = response.getJSONObject(count);
                        list.add(new Glid(object.getString("id"),object.getString("title")));
                        count++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                recycleAdapter = new RecycleAdapter(list,GiudeActivity.this);
                recyclerView.setAdapter(recycleAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
    }
}
