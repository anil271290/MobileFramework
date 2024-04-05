package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SmsOtp {

    private AppiumDriver driver;

    @AndroidFindBy(id = "com.commonfriend:id/edtOtp1")
    private WebElement otpBox1;
    @AndroidFindBy(id = "com.commonfriend:id/edtOtp2")
    private WebElement otpBox2;
    @AndroidFindBy(id = "com.commonfriend:id/edtOtp3")
    private WebElement otpBox3;
    @AndroidFindBy(id = "com.commonfriend:id/edtOtp4")
    private WebElement otpBox4;

    public SmsOtp(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String fetchAndInputOtp(String apiUrl) throws IOException {
        String otp = fetchOtp(apiUrl);
        inputOtp(otp);
        return otp;
    }



    public static String fetchOtp(String apiUrl) throws IOException {
        StringBuilder response = new StringBuilder();
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to POST
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // Construct the request body if required
        String requestBody = "{\"phoneNumber\":\"your_phone_number\"}"; // Modify this as per your API requirements

        // Write the request body to the connection
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Log the URL and request method
        System.out.println("Request URL: " + url);
        System.out.println("Request Method: " + connection.getRequestMethod());

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } else {
            // Log the response code
            System.out.println("Failed to fetch OTP. Response code: " + responseCode);
        }

        // Log the response
        System.out.println("Response: " + response.toString());

        return response.toString();
    }


    private void inputOtp(String otp) {
        if (otp.length() == 4) {
            char[] otpDigits = otp.toCharArray();
            otpBox1.sendKeys(String.valueOf(otpDigits[0]));
            otpBox2.sendKeys(String.valueOf(otpDigits[1]));
            otpBox3.sendKeys(String.valueOf(otpDigits[2]));
            otpBox4.sendKeys(String.valueOf(otpDigits[3]));
        } else {
            System.out.println("Invalid OTP length");
        }
    }
}
