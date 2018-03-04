package java112.project3;

import java.util.*;

/**
 * This class will be a JavaBean used to create an object of request data to be
 * passed to a jsp.
 * @author Elise Strauss
 * class HttpRequestData
 */
public class HttpRequestData {
    private String remoteComputer;
    private String addressRemoteComputer;
    private String httpMethod;
    private String uriRequest;
    private StringBuffer urlRequest;
    private String protocol;
    private String serverName;
    private int    serverPort;
    private Locale serverLocale;
    private String queryString;
    private String queryParameter;
    private String userAgent;

    /**
     * Empty Constructor for HttpRequestData
     */
    public HttpRequestData() {
    }

    /**
     * Sets the value of remoteComputer.
     * @param remoteComputer The value to assign remoteComputer.
     */
    public void setRemoteComputer(String remoteComputer) {
        this.remoteComputer = remoteComputer;
    }


    /**
     * Sets the value of addressRemoteComputer.
     * @param addressRemoteComputer The value to assign addressRemoteComputer.
     */
    public void setAddressRemoteComputer(String addressRemoteComputer) {
        this.addressRemoteComputer = addressRemoteComputer;
    }



    /**
     * Sets the value of httpMethod.
     * @param httpMethod The value to assign httpMethod.
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }



    /**
     * Sets the value of uriRequest.
     * @param uriRequest The value to assign uriRequest.
     */
    public void setUriRequest(String uriRequest) {
        this.uriRequest = uriRequest;
    }



    /**
     * Sets the value of urlRequest.
     * @param urlRequest The value to assign urlRequest.
     */
    public void setUrlRequest(StringBuffer urlRequest) {
        this.urlRequest = urlRequest;
    }



    /**
     * Sets the value of protocol.
     * @param protocol The value to assign protocol.
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }



    /**
     * Sets the value of serverName.
     * @param serverName The value to assign serverName.
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }



    /**
     * Sets the value of serverPort.
     * @param serverPort The value to assign serverPort.
     */
    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }



    /**
     * Sets the value of serverLocale.
     * @param serverLocale The value to assign serverLocale.
     */
    public void setServerLocale(Locale serverLocale) {
        this.serverLocale = serverLocale;
    }



    /**
     * Sets the value of queryString.
     * @param queryString The value to assign queryString.
     */
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }



    /**
     * Sets the value of queryParameter.
     * @param queryParameter The value to assign queryParameter.
     */
    public void setQueryParameter(String queryParameter) {
        this.queryParameter = queryParameter;
    }



    /**
     * Sets the value of userAgent.
     * @param userAgent The value to assign userAgent.
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * Returns the value of remoteComputer.
     * @return remoteComputer  The remote computer
     */
    public String getRemoteComputer() {
        return remoteComputer;
    }


    /**
     * Returns the value of addressRemoteComputer.
     * @return addressRemoteComputer
     */
    public String getAddressRemoteComputer() {
        return addressRemoteComputer;
    }


    /**
     * Returns the value of httpMethod.
     * @return httpMethod
     */
    public String getHttpMethod() {
        return httpMethod;
    }


    /**
     * Returns the value of uriRequest.
     * @return uriRequest
     */
    public String getUriRequest() {
        return uriRequest;
    }


    /**
     * Returns the value of urlRequest.
     * @return urlRequest
     */
    public StringBuffer getUrlRequest() {
        return urlRequest;
    }


    /**
     * Returns the value of protocol.
     * @return protocol
     */
    public String getProtocol() {
        return protocol;
    }


    /**
     * Returns the value of serverName.
     * @return serverName
     */
    public String getServerName() {
        return serverName;
    }


    /**
     * Returns the value of serverPort.
     * @return serverPort
     */
    public int getServerPort() {
        return serverPort;
    }


    /**
     * Returns the value of serverLocale.
     * @return serverLocale
     */
    public Locale getServerLocale() {
        return serverLocale;
    }


    /**
     * Returns the value of queryString.
     * @return queryString
     */
    public String getQueryString() {
        return queryString;
    }


    /**
     * Returns the value of queryParameter.
     * @return queryParameter
     */
    public String getQueryParameter() {
        return queryParameter;
    }


    /**
     * Returns the value of userAgent.
     * @return userAgent
     */
    public String getUserAgent() {
        return userAgent;
    }
}