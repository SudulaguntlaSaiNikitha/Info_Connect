//package com.example.infotech;
////
////import androidx.appcompat.app.AppCompatActivity;
////
////import android.os.Bundle;
////
////public class MainActivity extends AppCompatActivity {
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////    }
////}
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//    private TextView tvDiseaseInfo;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//    // Handle button clicks
//    public void onDiseaseButtonClick(View view) {
//        Button clickedButton = (Button) view;
//        String diseaseName = clickedButton.getText().toString();
//
//        // Set information about the selected disease in the TextView
//        DiseaseInfoProvider infoProvider = new DiseaseInfoProvider();
//        String diseaseInfo = infoProvider.getDiseaseInfo(diseaseName);
//
//        // Show custom caution dialog
//        showCautionDialog(diseaseName, diseaseInfo);
//    }
//
//    // Function to show custom caution dialog
//    private void showCautionDialog(String diseaseName, String diseaseInfo) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("*" + diseaseName)
//                .setMessage(diseaseInfo + "\n\nNOTE : Wait for a while \n          we will navigate to info")
//                .setPositiveButton("MOVE", null)
//                .show();
//    }
//}
//
//class DiseaseInfoProvider {
//
//    // Function to get information about the selected disease
//    public String getDiseaseInfo(String diseaseName) {
//        // Replace this with your logic to fetch information about each disease
//        // For demonstration, using a simple switch statement
//        switch (diseaseName) {
//            case "SCHEMES":
//                return "";
//            case "SCHORLARSHIPS":
//                return "";
//            case "JOBS":
//                return "";
//            case "NEWSUPDATES":
//                return "";
//            case "HUMANRIGHTS":
//                return "";
//            default:
//                return "";
//        }
//    }
//}
package com.example.infotech;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvDiseaseInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Handle button clicks
    public void onDiseaseButtonClick(View view) {
        Button clickedButton = (Button) view;
        String diseaseName = clickedButton.getText().toString();

        // Set information about the selected disease in the TextView
        DiseaseInfoProvider infoProvider = new DiseaseInfoProvider();
        String diseaseInfo = infoProvider.getDiseaseInfo(diseaseName);

        // Show custom caution dialog
        showCautionDialog(diseaseName, diseaseInfo);
    }

    // Function to show custom caution dialog
    private void showCautionDialog(final String diseaseName, String diseaseInfo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("*" + diseaseName)
                .setMessage(diseaseInfo + "\n\nNOTE :Please click On Move \n          we will navigate to info")
                .setPositiveButton("MOVE", (dialog, which) -> {
                    // Navigate to Myimage activity
                    Intent intent = new Intent(MainActivity.this, Myimage.class);
                    startActivity(intent);
                })
     .show();
    }
}

class DiseaseInfoProvider {

    // Function to get information about the selected disease
    public String getDiseaseInfo(String diseaseName) {
        // Replace this with your logic to fetch information about each disease
        // For demonstration, using a simple switch statement
        switch (diseaseName) {
            case "SCHEMES":
                return "Information about SCHEMES";
            case "SCHOLARSHIPS":
                return "Information about SCHOLARSHIPS";
            case "JOBS":
                return "Information about JOBS";
            case "NEWS UPDATES":
                return "Information about NEWS UPDATES";
            case "HUMAN RIGHTS":
                return "Information about HUMAN RIGHTS";
            default:
                return "";
        }
    }
}
