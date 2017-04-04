
package Data;

import Negocio.IP;
import Negocio.IIPMetodos;

/**
 *
 * @author alonso
 */
public class IPMetodos implements IIPMetodos{

    @Override
    public InformacionIP validarIp(IP ip) {
        InformacionIP mensaje = InformacionIP.IPValida;
        
        for (Integer octeto : ip.getOctetos()) {
            if (octeto > 255 || octeto < 0){
               mensaje = InformacionIP.IPNoValida;
               break;
            }
        }
                
        return mensaje;
    }

    @Override
    public InformacionIP determinarClaseIP(IP ip) {
        InformacionIP tipoIP = null;
        
        if(ip.getOctetos().get(0) <= 127){
            tipoIP = InformacionIP.IPClaseA;
        }else{
            if(ip.getOctetos().get(0) <= 191){
                tipoIP = InformacionIP.IPClaseB;
            }else{
                if (ip.getOctetos().get(0) <= 223)
                    tipoIP = InformacionIP.IPClaseC;
                else
                    tipoIP = InformacionIP.IPClaseD_E;
            }
        }
        
        return tipoIP;
    }

    @Override
    public String calcularPrefijo(InformacionIP tipoIP) {
        String prefijo = "";
        
         switch(tipoIP){
            
            case IPClaseA:
                prefijo = "/8";
                break;
                
            case IPClaseB:
                prefijo = "/16";
                break;
                
            case IPClaseC:
                prefijo = "/24";
                break;
            
            case IPClaseD_E:
                break;
            
        }
         
        return prefijo;
    }

    @Override
    public String calcularMacara(InformacionIP tipoIP) {
        String mascara= "";
        
        switch(tipoIP){
            
            case IPClaseA:
                mascara = "255.0.0.0";
                break;
                
            case IPClaseB:
                mascara = "255.255.0.0";
                break;
                
            case IPClaseC:
                mascara = "255.255.255.0";
                break;
            
            case IPClaseD_E:
                break;
            
        }
        return mascara;
    }

    @Override
    public String calcularDireccionRed(IP ip, InformacionIP tipoIP) {
        String direccionRed = "";
        
        switch(tipoIP){
            
            case IPClaseA:
                direccionRed = ip.getOctetos().get(0) + ".0.0.0";
                break;
                
            case IPClaseB:
                direccionRed = ip.getOctetos().get(0) + "." + ip.getOctetos().get(1) + ".0.0";
                break;
                
            case IPClaseC:
                direccionRed = ip.getOctetos().get(0) + "." + ip.getOctetos().get(1) + "." + ip.getOctetos().get(1) + ".0";
                break;
            
            case IPClaseD_E:
                break;
        }
        
        return direccionRed;
    }

    @Override
    public String calularDireccionBroadcast(IP ip, InformacionIP tipoIP) {
        String direccionBroadcast = "";
        
          switch(tipoIP){
            
            case IPClaseA:
                direccionBroadcast = ip.getOctetos().get(0) + ".255.255.255";
                break;
                
            case IPClaseB:
                direccionBroadcast = ip.getOctetos().get(0) + "." + ip.getOctetos().get(1) + ".255.255";
                break;
                
            case IPClaseC:
                direccionBroadcast = ip.getOctetos().get(0) + "." + ip.getOctetos().get(1) + "." + ip.getOctetos().get(1) + ".255";
                break;
            
            case IPClaseD_E:
                break;
        }
        
        return direccionBroadcast;
    }
    
}
