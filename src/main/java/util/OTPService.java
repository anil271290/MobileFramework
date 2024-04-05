package util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class OTPService {
    private AppiumDriver driver;

    @AndroidFindBy(id = "com.commonfriend:id/edtOtp1")
    public WebElement otpBox1;
    @AndroidFindBy(id = "com.commonfriend:id/edtOtp2")
    public WebElement otpBox2;
    @AndroidFindBy(id = "com.commonfriend:id/edtOtp3")
    public WebElement otpBox3;
    @AndroidFindBy(id = "com.commonfriend:id/edtOtp4")
    public WebElement otpBox4;

    public OTPService(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static String getOTPFromServer(String countryCode, String mobileNumber) {
        String apiUrl = "https://staging-api.commonfriend.com/api/v2/register";
        String responseBody = "";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(apiUrl);

            // Create JSON object with country code and mobile number
            Gson gson = new Gson();
            String jsonRequestBody = gson.toJson(new OtpRequest(countryCode, mobileNumber));

            // Set JSON as request body
            StringEntity entity = new StringEntity(jsonRequestBody);
            request.setEntity(entity);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");

            // Execute the request
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    responseBody = EntityUtils.toString(responseEntity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       // return responseBody;

        return extractOTP(responseBody);
    }

    // Define a class to represent the request body JSON structure
    static class OtpRequest {
        private String country_code;
        private String mobile_no;

        public OtpRequest(String countryCode, String mobileNumber) {
            this.country_code = countryCode;
            this.mobile_no = mobileNumber;
        }
    }

    // Method to extract OTP value from JSON response
    private static String extractOTP(String responseBody) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
        JsonArray dataArray = jsonObject.getAsJsonArray("data");
        JsonObject dataObject = dataArray.get(0).getAsJsonObject();
        int otpValue = dataObject.getAsJsonPrimitive("OTP").getAsInt();
        return String.valueOf(otpValue);
    }

    public void enterOTP(String otp) {
        // Split the OTP string into individual digits
        char[] otpDigits = otp.toCharArray();

        // Enter each digit into the corresponding OTP input box
        otpBox1.sendKeys(Character.toString(otpDigits[0]));
        otpBox2.sendKeys(Character.toString(otpDigits[1]));
        otpBox3.sendKeys(Character.toString(otpDigits[2]));
        otpBox4.sendKeys(Character.toString(otpDigits[3]));
    }
}
