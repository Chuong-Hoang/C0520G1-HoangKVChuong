package controllers;

import model.PdfDrawing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.Shape;

@Controller
@RequestMapping("/pdf")
public class PdfDrawingController {
    @Autowired
    PdfDrawing pdfDrawing;
    @Autowired
    PdfDrawing pdfDrawing1;
    @Autowired
    PdfDrawing pdfDrawing2;
    @Autowired
    Shape shape;

    @GetMapping
    public String getPdfPage(Model model){
        pdfDrawing.setShape(shape);
        String content = pdfDrawing.showContent();
        String content1 = pdfDrawing1.showContent();
        String content2 = pdfDrawing2.showContent();
        model.addAttribute("content", content);
        model.addAttribute("content1", content1);
        model.addAttribute("content2", content2);
        return "/pdf";
    }
}
