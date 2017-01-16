package com.coolweatherpractice.util;

import android.text.TextUtils;

import com.coolweatherpractice.db.City;
import com.coolweatherpractice.db.County;
import com.coolweatherpractice.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hcywff on 2017/1/15.
 */

public class Utility {

    /**
     * 解析和处理服务器返回的省一级数据
     *
     * @param response (service back json string)
     * @return
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                int len = allProvinces.length();
                for (int i = 0; i < len; i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province pro = new Province();
                    pro.setProvinceName(provinceObject.getString("name"));
                    pro.setProvinceCode(provinceObject.getInt("id"));
                    pro.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的城市一级数据
     *
     * @param response (service back json string)
     * @return
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                int len = allCities.length();
                for (int i = 0; i < len; i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县一级数据
     *
     * @param response (service back json string)
     * @return
     */
    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                int len = allCounties.length();
                for (int i = 0; i < len; i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
