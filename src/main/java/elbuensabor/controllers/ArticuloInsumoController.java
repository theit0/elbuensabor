package elbuensabor.controllers;

import elbuensabor.entities.ArticuloInsumo;
import elbuensabor.services.ArticuloInsumoServiceImpl;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/ArticuloInsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl>{
}
