package com.kdnakt.tls;

import java.io.IOException;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

public class App {

    public static void main(String[] args) throws IOException {
        printProperty("os.name");
        printProperty("os.arch");
        printProperty("java.version");
        printProperty("java.vendor");
        printProperty("java.vm.name");
        printProperty("java.home");

        if (args.length < 1) throw new RuntimeException("Not enough arguments!");
        System.out.println("Target: " + args[0]);
        GetMethod method = new GetMethod(args[0]);

        HttpClient client = newClient();
        try {
            int res = client.executeMethod(method);
            System.out.println("response code: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(method.getStatusCode());
    }

    static void printProperty(String name) {
        System.out.println(name + ": " + System.getProperty(name));
    }

    static HttpClient newClient() {
        HttpClient client = new HttpClient(newConnManager());
        client.getHostConfiguration().getParams().setParameter(
                "http.useragent", "api-client");
        return client;
    }

    static MultiThreadedHttpConnectionManager newConnManager() {
        MultiThreadedHttpConnectionManager man = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = man.getParams();
        params.setConnectionTimeout(3 * 1000);
        params.setSoTimeout(3 * 1000);
        params.setMaxTotalConnections(100);
        params.setMaxConnectionsPerHost(new HostConfiguration(), 100);
        return man;
    }

}
