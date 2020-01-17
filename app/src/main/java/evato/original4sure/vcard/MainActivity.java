package evato.original4sure.vcard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mName, mCompanyName, mPhone, mWorkPhone, mEmail;
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    private static final String URL = "192.168.1.5:3014/api";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = findViewById(R.id.etv_name);
        mCompanyName = findViewById(R.id.etv_org);
        mPhone = findViewById(R.id.etv_phone);
        mWorkPhone = findViewById(R.id.etv_work);
        mEmail = findViewById(R.id.etv_email);
        Button submitButton = findViewById(R.id.btn_submit);
        submitButton.setOnClickListener(this);
    }

    private void validateInput() {
        boolean failFlag = false;
        if (mName.getText().toString().trim().length() == 0) {
            failFlag = true;
            mName.setError("Field can not be empty");
        }
        if (mCompanyName.getText().toString().trim().length() == 0) {
            failFlag = true;
            mCompanyName.setError("Field can not be empty");
        }
        if (mPhone.getText().toString().trim().length() == 0) {
            failFlag = true;
            mPhone.setError("Field can not be empty");
        }
        if (mWorkPhone.getText().toString().trim().length() == 0) {
            failFlag = true;
            mWorkPhone.setError("Field can not be empty");
        }
        if (mEmail.getText().toString().trim().length() == 0) {
            failFlag = true;
            mEmail.setError("Field can not be empty");
        }
        if (!failFlag) {
            extractTextFromFields();
        }
    }

    private void extractTextFromFields() {
        String name = mName.getText().toString();
        String companyName = mCompanyName.getText().toString();
        String email = mEmail.getText().toString();
        String workPhone = mWorkPhone.getText().toString();
        String phone = mPhone.getText().toString();
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("")
//        post(URL,);
    }

//    String post(String url, String json) throws IOException {
//        RequestBody body = RequestBody.create(JSON, json);
//        Request request = new Request.Builder()
//                .url(url)
//                .post(body)
//                .build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//
//            }
//        });
//    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_submit) {
            validateInput();
        }
    }

}
