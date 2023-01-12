package com.example.demo;

import java.io.IOException;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;


@Service
public class PDFGeneratorService {
	@Autowired
	private UserService userService;
	@Autowired
	private ActivityService actService;
	
    public void export(HttpServletResponse response, Abonnement abon) throws IOException {
		User user = userService.findUserById(abon.getIdUser());
		Activity activity=actService.findActivityById(abon.getIdActivity());


        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("Abonnement informations \n \n", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);
        
        String msg="Hello our Subscriber,a very warm welcome to you! It is lovely to have you among us! \n";
        
        Paragraph paragraph1 = new Paragraph(msg, fontParagraph);
        paragraph1.setAlignment(Paragraph.ALIGN_LEFT);
        
        Paragraph paragraph2 = new Paragraph("\n Identifant : "+abon.getId(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        
        Paragraph paragraph3 = new Paragraph("\n Name and username : "+user.getNom()+"\t"+user.getPrenom(), fontParagraph);
        paragraph3.setAlignment(Paragraph.ALIGN_LEFT);
        
        Paragraph paragraph4 = new Paragraph("\n Activity name : "+activity.getNom(), fontParagraph);
        paragraph4.setAlignment(Paragraph.ALIGN_LEFT);
        
        Paragraph paragraph5 = new Paragraph("\n Activity price : "+activity.getPrix(), fontParagraph);
        paragraph5.setAlignment(Paragraph.ALIGN_LEFT);
        
        Paragraph paragraph6 = new Paragraph("\n Subscription period: "+abon.getDateD()+"/"+abon.getDateF(), fontParagraph);
        paragraph5.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(paragraph1);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(paragraph4);
        document.add(paragraph5);
        document.add(paragraph6);
        document.close();
    }
}