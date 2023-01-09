package org.example.ejerciciocontroller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class controller {
    @GetMapping("/**")
    public ControllerObject handleRequest(HttpServletRequest request,
                                          @RequestParam Map<String, String> querys,
                                          @RequestHeader Map<String, String> headers) {

        ControllerObject controllerObject = new ControllerObject();

        //Creo listas con los valores de headers y querys
        List<Header> headersList = createHeadersList(headers);
        List<Query> querysList = createQuerysList(querys);

        // Asigna los valores a los campos de controllerObject
        controllerObject.setPaths(extractPaths(request));
        controllerObject.setQuerys(querysList);
        controllerObject.setHeaders(headersList);

        //Esto extrae la IP remota, si se muestra 0.0.0.0.0.0.1 es porque estás intentando acceder
        // a tu local machine pero si alguien externo lo intenta en la maquina funcionaría mostrando la IP
        //request.getRemoteAddr() o getLocalAddr() para el server donde corre la app
        controllerObject.setUrlOrigen(request.getLocalAddr());

        return controllerObject;
    }

    private List<String> extractPaths(HttpServletRequest request) {
        // Extrae la ruta de la petición y la divide en una lista de segmentos
        String path = request.getRequestURI().substring(request.getContextPath().length());
        return Arrays.asList(path.split("/"));
    }
// Creamos una lista X donde con un for añadimos los name - values de los headers que le pasamos desde los request
    private List<Header> createHeadersList(Map<String, String> headersMap) {

        List<Header> headersList = new ArrayList<>();

        for (Map.Entry<String, String> entry : headersMap.entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue();
            headersList.add(new Header(name, value));
        }
        return headersList;
    }
    // Creamos una lista X donde con un for añadimos los name - values almacenados en un mapa
    // de los querys que le pasamos desde los request
    private List<Query> createQuerysList(Map<String, String> querysMap) {
        List<Query> querysList = new ArrayList<>();
        for (Map.Entry<String, String> entry : querysMap.entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue();
            querysList.add(new Query(name, value));
        }
        return querysList;
    }


}




