package org.jmoney8080;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSCaching {

    public static void main(String[] args) {
        java.security.Security.setProperty("networkaddress.cache.ttl", "5");

        final String host = args[0];

        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(String.format("host=%s, ip=%s", host, InetAddress.getByName(host).getHostAddress()));

                Thread.sleep(5000);
            } catch (UnknownHostException e) {
                System.err.println("unknown host: " + host);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
