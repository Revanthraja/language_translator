package com.example.language;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    private Translator translatorGerman;
    private Translator translatorArabic;
    private Translator translatorKorean;
    private Translator translatorHindi;
    private Translator translatorBengali;

    private Boolean booleanGerman = false;
    private Boolean booleanArabic = false;
    private Boolean booleanKorean = false;
    private Boolean booleanHindi=false;
    private Boolean booleanBengali=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);


        TranslatorOptions translatorOptionsGerman = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.GERMAN)
                .build();

        TranslatorOptions translatorOptionsArabic = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.ARABIC)
                .build();

        TranslatorOptions translatorOptionsKorean = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.KOREAN)
                .build();
        TranslatorOptions translatorOptionsHindi = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.HINDI)
                .build();
        TranslatorOptions translatorOptionsBengali = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.BENGALI)
                .build();



        translatorGerman = Translation.getClient(translatorOptionsGerman);
        translatorArabic = Translation.getClient(translatorOptionsArabic);
        translatorKorean = Translation.getClient(translatorOptionsKorean);
        translatorHindi = Translation.getClient(translatorOptionsHindi);
        translatorBengali = Translation.getClient(translatorOptionsBengali);


        downloadModel();
    }

    private void downloadModel(){
        DownloadConditions downloadConditions = new DownloadConditions.Builder()
                .requireWifi()
                .build();

        translatorGerman.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanGerman = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanGerman = false;
                    }
                });

        translatorArabic.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanArabic = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanArabic = false;
                    }
                });

        translatorKorean.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanKorean = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanKorean = false;
                    }
                });
        translatorHindi.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanHindi = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanHindi = false;
                    }
                });
        translatorBengali.downloadModelIfNeeded(downloadConditions)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        booleanBengali = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        booleanBengali = false;
                    }
                });
    }

    public void buttonDownloadModel(View view){
        downloadModel();
    }

    public void buttonGerman(View view){

        if (booleanGerman){
            translatorGerman.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {

                            textView.setText(s);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            textView.setText(e.toString());
                        }
                    });
        }
    }

    public void buttonArabic(View view){

        if (booleanGerman){
            translatorArabic.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            textView.setText(s);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            textView.setText(e.toString());
                        }
                    });
        }
    }

    public void buttonKorean(View view){
        if (booleanGerman){
            translatorKorean.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            textView.setText(s);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            textView.setText(e.toString());
                        }
                    });
        }
    }
    public void buttonHindi(View view){
        if (booleanGerman){
            translatorHindi.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            textView.setText(s);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            textView.setText(e.toString());
                        }
                    });
        }
    }
    public void buttonBengali(View view){
        if (booleanGerman){
            translatorBengali.translate(editText.getText().toString())
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            textView.setText(s);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            textView.setText(e.toString());
                        }
                    });
        }
    }
}