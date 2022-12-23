package sn.groupeisi.dp.ressource;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import sn.groupeisi.dp.service.PDFGeneredService;
@RestController
public class PDFEXPORTRessource {
    private final PDFGeneredService pdfGeneredService;
    @Autowired
    public PDFEXPORTRessource(PDFGeneredService pdfGeneredService){
        this.pdfGeneredService= pdfGeneredService;
    }
    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse  response) throws DocumentException, IOException{

        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormat.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        this.pdfGeneredService.export(response);
    }
}
