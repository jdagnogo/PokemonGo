package com.example.jdagnogo.pokemongo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.jdagnogo.pokemongo.R;
import com.pokegoapi.api.PokemonGo;
import com.pokegoapi.api.map.pokemon.CatchResult;
import com.pokegoapi.api.map.pokemon.CatchablePokemon;
import com.pokegoapi.api.map.pokemon.EncounterResult;
import com.pokegoapi.api.pokemon.Pokemon;
import com.pokegoapi.auth.GoogleAuthJson;
import com.pokegoapi.auth.GoogleAuthTokenJson;
import com.pokegoapi.auth.GoogleCredentialProvider;

import java.util.List;

import POGOProtos.Data.Player.PlayerStatsOuterClass;
import POGOProtos.Enums.PokemonIdOuterClass;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private WebView webView;
    private TextView textView;
    GoogleCredentialProvider.OnGoogleLoginOAuthCompleteListener listnr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        textView = (TextView) findViewById(R.id.text);
        webView.loadUrl("https://www.google.com/device");
        webView.setWebViewClient(new WebViewClient(
        ) {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });

        listnr = new GoogleCredentialProvider.OnGoogleLoginOAuthCompleteListener() {
            @Override
            public void onInitialOAuthComplete(final GoogleAuthJson googleAuthJson) {
                Log.d(LOG_TAG, "onInitialOauthComplete " + googleAuthJson.getUserCode() + " " + googleAuthJson.getDeviceCode());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(googleAuthJson.getUserCode());
                        // webView.loadUrl("javascript:document.getElementById('single_input_user_code').value = '"+textView.getText().toString()+"';");
                    }
                });

            }

            @Override
            public void onTokenIdReceived(GoogleAuthTokenJson googleAuthTokenJson) {
                Log.d(LOG_TAG, "onTokenIdReceived " + googleAuthTokenJson);
            }
        };
        new getPoke().execute();
    }

    private class getPoke extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {

            try {
                Log.v(LOG_TAG, "login : ");
                OkHttpClient httpClient = new OkHttpClient();
                PokemonGo go = new PokemonGo(new GoogleCredentialProvider(httpClient, listnr), httpClient);
                PlayerStatsOuterClass.PlayerStats person = go.getPlayerProfile().getStats();
                List<Pokemon> pokemons = go.getInventories().getPokebank().getPokemons();
                for(Pokemon p:pokemons){
                    Log.i("mlabouardy",p.getNickname()+" "+p.getCp());
                }
                go.getInventories().getPokebank().getPokemonByPokemonId(PokemonIdOuterClass.PokemonId.PIDGEY);
                String speudo = go.getPlayerProfile().getUsername();
                int battleAttack= person.getBattleAttackWon();
                int battleDefend = person.getBattleDefendedWon();
                int battleTotalAttack = person.getBattleAttackTotal();
                int bigMagicark = person.getBigMagikarpCaught();
                int nbEvolution = person.getEvolutions();
                int level = person.getLevel();
                int nbPokeballUse = person.getPokeballsThrown();
                int nbPokemonCapture = person.getPokemonsCaptured();
                int nbPokestop = person.getPokeStopVisits();
                ProfileInformation profileInformation = new ProfileInformation(speudo,battleAttack,battleDefend,battleTotalAttack,bigMagicark,nbEvolution,level,nbPokeballUse,nbPokemonCapture,nbPokestop);

                Log.d(LOG_TAG, "personal informations : "+profileInformation.toString());
            } catch (Exception e) {
                Log.d(LOG_TAG, "error:" + e.toString());
            }

            return null;
        }
    }
}