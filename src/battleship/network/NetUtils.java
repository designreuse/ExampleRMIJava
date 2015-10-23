package battleship.network;


import java.net.*;
import java.util.Enumeration;

    public class NetUtils {

        private static NetUtils instance;

        private NetUtils(){};

        public static NetUtils getInstance(){
            if(instance == null)
                instance = new NetUtils();
            return instance;
        }

        /**
         * Ritorna un indirizzo ip pubblico della macchina
         * @return un indirizzo pubblico della macchina, null ne la macchina non ne ha
         * @throws UnknownHostException
         */
        public InetAddress getPublicIP() throws UnknownHostException {

            //Ottengo tutti gli IP della macchina
            String hostName = InetAddress.getLocalHost().getHostName();
            InetAddress addrs[] = InetAddress.getAllByName(hostName);

            for (InetAddress addr : addrs) {
                if (!addr.isLoopbackAddress() && addr.isSiteLocalAddress()) {
                    return addr;
                }
            }

            return null;
        }

        /**
         * Ritorna un indirizzo ip pubblico della macchina
         * @return un indirizzo pubblico della macchina, null ne la macchina non ne ha
         * @throws UnknownHostException
         */
        public String getHostAddress() throws UnknownHostException, SocketException {


            for(Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces(); ni.hasMoreElements();) {
                NetworkInterface iface = ni.nextElement();
                if (iface.getName() != "lo") {
                    for(Enumeration<InetAddress> addresses = iface.getInetAddresses(); addresses.hasMoreElements();){
                        InetAddress address = addresses.nextElement();
                        if(address instanceof Inet4Address)
                            return address.getHostAddress();
                    }
                }
            }

            return null;
        }

}