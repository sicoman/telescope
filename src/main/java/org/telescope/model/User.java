
package org.telescope.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.telescope.database.QueryExtended;
import org.telescope.database.QueryIgnore;
import org.telescope.javel.framework.helper.Hashing;

import java.util.Date;

public class User extends ExtendedModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private boolean readonly;

    public boolean getReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    private boolean administrator;

    public boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    private String map;

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    private double latitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    private double longitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    private int zoom;

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    private boolean twelveHourFormat;

    public boolean getTwelveHourFormat() {
        return twelveHourFormat;
    }

    public void setTwelveHourFormat(boolean twelveHourFormat) {
        this.twelveHourFormat = twelveHourFormat;
    }

    private String coordinateFormat;

    public String getCoordinateFormat() {
        return coordinateFormat;
    }

    public void setCoordinateFormat(String coordinateFormat) {
        this.coordinateFormat = coordinateFormat;
    }

    private boolean disabled;

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    private Date expirationTime;

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    private int deviceLimit;

    public int getDeviceLimit() {
        return deviceLimit;
    }

    public void setDeviceLimit(int deviceLimit) {
        this.deviceLimit = deviceLimit;
    }

    private int userLimit;

    public int getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(int userLimit) {
        this.userLimit = userLimit;
    }

    private boolean deviceReadonly;

    public boolean getDeviceReadonly() {
        return deviceReadonly;
    }

    public void setDeviceReadonly(boolean deviceReadonly) {
        this.deviceReadonly = deviceReadonly;
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        if (token != null && !token.isEmpty()) {
            if (!token.matches("^[a-zA-Z0-9-]{16,}$")) {
                throw new IllegalArgumentException("Illegal token");
            }
            this.token = token;
        } else {
            this.token = null;
        }
    }

    private boolean limitCommands;

    public boolean getLimitCommands() {
        return limitCommands;
    }

    public void setLimitCommands(boolean limitCommands) {
        this.limitCommands = limitCommands;
    }

    private String poiLayer;

    public String getPoiLayer() {
        return poiLayer;
    }

    public void setPoiLayer(String poiLayer) {
        this.poiLayer = poiLayer;
    }
    
    private String passwordToAdmin;

    @QueryIgnore
    @JsonIgnore
    public String getPasswordToAdmin() {
        return passwordToAdmin;
    }

    @QueryIgnore
    public String getPassword() {
        return null;
    }

    public void setPassword(String password) {
    	this.passwordToAdmin = password;
        if (password != null && !password.isEmpty()) {
            Hashing.HashingResult hashingResult = Hashing.createHash(password);
            hashedPassword = hashingResult.getHash();
            salt = hashingResult.getSalt();
        }
    }

    private String hashedPassword;

    @JsonIgnore
    @QueryExtended
    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    private String salt;

    @JsonIgnore
    @QueryExtended
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean isPasswordValid(String password) {
        return Hashing.validatePassword(password, hashedPassword, salt);
    }

}