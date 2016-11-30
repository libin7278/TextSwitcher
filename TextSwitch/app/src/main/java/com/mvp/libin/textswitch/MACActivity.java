package com.mvp.libin.textswitch;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 通过WiFi获取mac地址
 */
public class MACActivity extends Activity {
    private static final String TAG_NETWORK = "TAG";
    private TextView tv;
    private TextView SSID;

    String mac_s= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mac);

        tv = (TextView) findViewById(R.id.tv);
        SSID = (TextView) findViewById(R.id.SSID);

        String localMacAddressFromWifiInfo = getLocalMacAddressFromWifiInfo(this);

        tv.setText(getLocalMacAddressFromWifiInfo(this));
        SSID.setText(getLocalMacSSIDFromWifiInfo(this));

    }

    public String getLocalMacAddressFromWifiInfo(Context context){
        //Getting the connection info
        WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);

        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();

        String[] split = dhcpInfo.toString().split(" ");

        try {
            NetworkInterface ne=NetworkInterface.getByInetAddress(InetAddress.getByName(split[1]));
            byte[] mac = ne.getHardwareAddress();
            mac_s = byte2hex(mac);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return mac_s;
    }

    /**
     * 二进制转十六进制
     * @param b
     * @return
     */
    public static  String byte2hex(byte[] b) {
        StringBuffer hs = new StringBuffer(b.length);
        String stmp = "";
        int len = b.length;
        for (int n = 0; n < len; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1)
                hs = hs.append("0").append(stmp);
            else {
                hs = hs.append(stmp);
            }
        }
        return String.valueOf(hs);
    }

    public String getLocalMacSSIDFromWifiInfo(Context context){
        //Getting the connection info
        WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        //Access point's MAC address
        String bssid = wifiInfo.toString();

        return bssid;
    }
    public String getLocalNETWORKFromWifiInfo(Context context){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();

        return activeNetworkInfo.toString();
    }

    public String getLocalNETFromWifiInfo(Context context){
       return null;
    }

    /**
     * 通过callCmd("busybox ifconfig","HWaddr")获取mac地址
     * @attention 需要设备装有busybox工具
     * @return Mac Address
     */
    private String getMacFromCallCmd(){
        String result = "";
        result = callCmd("busybox ifconfig","HWaddr");

        if(result == null || result.length() <= 0){
            Log.i(TAG_NETWORK,"callCmd returns null or empty");
            return null;
        }

        //对该行数据进行解析
        //例如：eth0      Link encap:Ethernet  HWaddr 00:16:E8:3E:DF:67
        if(result.length()>0 && result.contains("HWaddr")==true){
            String Mac = result.substring(result.indexOf("HWaddr")+6, result.length()-1);
            Log.i(TAG_NETWORK,"Mac:"+Mac+" Mac.length: "+Mac.length());
            if(Mac.length()>1){
                Mac = Mac.replaceAll(" ", "");
                result = "";

                String[] tmp = Mac.split(":");
                for(int i = 0;i<tmp.length;++i){
                    result +=tmp[i];
                }
            }

            Log.i(TAG_NETWORK,result+" result.length: "+result.length());
        }
        Log.i(TAG_NETWORK,"Mac address(CallCmd): "+result);

        return result;
    }

    public String callCmd(String cmd,String filter) {
        String result = "";
        String line = "";
        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            InputStreamReader is = new InputStreamReader(proc.getInputStream());
            BufferedReader br = new BufferedReader (is);

            //执行命令cmd，只取结果中含有filter的这一行
            while ((line = br.readLine ()) != null && line.contains(filter)== false) {
                //result += line;
                Log.i("test","line: "+line);
            }

            result = line;
            Log.i("test","result: "+result);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
