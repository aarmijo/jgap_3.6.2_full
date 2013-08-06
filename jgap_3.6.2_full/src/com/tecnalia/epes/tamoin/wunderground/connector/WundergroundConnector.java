/*
 * WundergroundConnector.java
 * 
 * Created on 10-01-2012
 * 
 * Copyright (C) 2012 Tomas Travnicek, All rights reserved.
 */
package com.tecnalia.epes.tamoin.wunderground.connector;

import com.tecnalia.epes.tamoin.wunderground.data.autocomplete.AutocompleteEnvelope;
import com.tecnalia.epes.tamoin.wunderground.data.autocomplete.Result;
import com.tecnalia.epes.tamoin.wunderground.data.envelope.WundergroundEnvelope;
import com.tecnalia.epes.tamoin.wunderground.data.forecast.Forecast;
import com.tecnalia.epes.tamoin.wunderground.data.moonphase.MoonPhase;
import com.tecnalia.epes.tamoin.wunderground.data.observations.CurrentObservation;
import com.tecnalia.epes.tamoin.wunderground.data.response.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomas Travnicek <travnicek.tomas at gmail.com>
 * @version $Id: WundergroundConnector.java 10-01-2012 9:57:08 ttravnicek
 */
public class WundergroundConnector {
    
    private WundergroundEnvelope envelopedResults;
    private AutocompleteEnvelope autocompleteResults;
    private String apiUrl;
    private String apiUrlAutocomplete;
    private String apiKey;
    private String features;
    private String language;
    private String location;
    private String responseFormat;

    /**
     * 
     * @param prop
     * @throws MalformedURLException
     * @throws IOException
     */
    public WundergroundConnector(Properties prop) throws WunderException {
        apiUrl = prop.getProperty("wundergroundApi.URL");
        apiUrlAutocomplete = prop.getProperty("wundergroundApi.URLAutocomplete");
        apiKey = prop.getProperty("wundergroundApi.key");
        features = prop.getProperty("wundergroundApi.features");
        language = prop.getProperty("wundergroundApi.language");
        location = prop.getProperty("wundergroundApi.location");
        responseFormat = prop.getProperty("wundergroundApi.responseFormat");
    }
    
    /**
     * 
     * @return
     */
    public boolean getDataFromWunder() {
        try {
            init(false, false);
            return true;
        } catch (WunderException ex) {
            Logger.getLogger(WundergroundConnector.class.getName()).log(Level.SEVERE, "Error while refreshing Wunderground data.", ex);
            return false;
        }
    }
    
    public boolean getAutocompleteDataFromWunder() {
        try {
            init(true, false);
            return true;
        } catch (WunderException ex) {
            Logger.getLogger(WundergroundConnector.class.getName()).log(Level.SEVERE, "Error while refreshing Wunderground data.", ex);
            return false;
        }
    }
    
    public boolean getAutocompleteHurricaneDataFromWunder() {
        try {
            init(true, true);
            return true;
        } catch (WunderException ex) {
            Logger.getLogger(WundergroundConnector.class.getName()).log(Level.SEVERE, "Error while refreshing Wunderground data.", ex);
            return false;
        }
    }

    private void init(boolean isAutocomplete, boolean isHurricaneAutocomplete) throws WunderException {
        URL wundergroundURL;
        try {
            if (isAutocomplete) {
                if (isHurricaneAutocomplete) {
                    wundergroundURL = new URL(
                            apiUrlAutocomplete + "aq?query=" + location + "&format=" + responseFormat + "&h=1&cities=0");
                } else {
                    wundergroundURL = new URL(
                            apiUrlAutocomplete + "aq?query=" + location + "&format=" + responseFormat);
                }
            } else {
                wundergroundURL = new URL(
                        apiUrl + apiKey + "/" + features + "lang:" + language
                        + "/q/" + location + "." + responseFormat);
            }
            
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            InputStream inputStream = wundergroundURL.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            if (isAutocomplete) {
                autocompleteResults = gson.fromJson(br, AutocompleteEnvelope.class);
            } else {
                envelopedResults = gson.fromJson(br, WundergroundEnvelope.class);
            }
        } catch (MalformedURLException e) {
            throw new WunderException(WunderException.ERROR_IO_ERROR, "Malformed Wunderground request URI.");
        } catch (IOException e) {
            throw new WunderException(WunderException.ERROR_IO_ERROR, "IO error while requesting data from Wunderground.");
        } catch (JsonIOException e) {
            throw new WunderException(WunderException.ERROR_IO_ERROR, "IO error while requesting data from Wunderground.");
        } catch (JsonSyntaxException e) {
            throw new WunderException(WunderException.ERROR_JSON_PARSE_ERROR, "Error while parsing JSON response from Wunderground."+e.getMessage());
        }
    }
    
    /**
     * 
     * @return
     */
    public WundergroundEnvelope getEnvelope() {
        return envelopedResults;
    }
    
    /**
     * 
     * @return
     */
    public Response getResponse() {
        return envelopedResults.getResponse();
    }
    
    /**
     * 
     * @return
     */
    public CurrentObservation getCurrentObservation() {
        return envelopedResults.getCurrent_observation();
    }
    
    /**
     * 
     * @return
     */
    public Forecast getForecast() {
        return envelopedResults.getForecast();
    }
    
    /**
     * 
     * @return
     */
    public MoonPhase getMoonPhase() {
        return envelopedResults.getMoon_phase();
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setZmwLocation(String location) {
        this.location = "zmw:"+location;
    }

    public void setResponseFormat(String responseFormat) {
        this.responseFormat = responseFormat;
    }

    public List<Result> getAutocompleteResults() {
        return autocompleteResults.getResults();
    }
    
}
