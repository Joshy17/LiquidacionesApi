/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Liquidacion.Liquidicacion.Candelarizado;

import Liquidacion.Liquidicacion.Controllers.SftpController;
import java.util.logging.Logger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author XPC
 */
@Component
public class Candelarizado {
    
    private final SftpController sftpController;
    private final Logger logger = Logger.getLogger(Candelarizado.class.getName());
    
    public Candelarizado(SftpController sftpController) {
        this.sftpController = sftpController;
    }

    @Scheduled(cron = "0 45 23 * * *")
    public void executeDailyTask() {
        System.out.println("Ejecutando tarea diaria para listar archivos...");
        logger.info("Ejecutando tarea diaria para listar archivos...");
        String result = sftpController.listarArchivos();
        System.out.println("Resultado de la tarea diaria:\n" + result);
        logger.info("Resultado de la tarea diaria:\n" + result);

    }
}