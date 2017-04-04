
package Negocio;

import Data.InformacionIP;

/**
 *
 * @author alonso
 */
public interface IIPMetodos {
    public InformacionIP validarIp(IP ip);
    public InformacionIP determinarClaseIP(IP ip);
    public String calcularPrefijo(InformacionIP tipoIP);
    public String calcularMacara(InformacionIP tipoIP);
    public String calcularDireccionRed(IP ip, InformacionIP tipoIP);
    public String calularDireccionBroadcast(IP ip, InformacionIP tipoIP);
}
