package vn.codegym.chuong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.chuong.model.student_model.Student;
import vn.codegym.chuong.model.test_model.Question;
import vn.codegym.chuong.service.test_service.QuestionService;
import vn.codegym.chuong.service.test_service.QuestionTypeService;
import vn.codegym.chuong.service.test_service.TestUserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/question")
public class QuestionController {
    // Constants
    private final String EL_NAME = "question";
    private final String LIST_PAGE = EL_NAME + "/list";
    private final String CREATE_PAGE = EL_NAME + "/create";
    private final String EDIT_PAGE = EL_NAME + "/edit";
    private final String DELETE_PAGE = EL_NAME + "/delete";
    private final String VIEW_PAGE = EL_NAME + "/view";
    private final String REDIRECT_TO_LIST = "redirect:/" + EL_NAME;

    private final String LIST_MSG = "Total of " + EL_NAME + ": ";
    private final String CREATE_MSG = "Create new " + EL_NAME + " successfully.";
    private final String EDIT_MSG = "Update the " + EL_NAME + " successfully.";
    private final String DELETE_MSG = "Delete the " + EL_NAME + " successfully.";
    private final String DELETE_MANY_MSG = "Delete the selected " + EL_NAME + "(s) successfully.";

    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionTypeService questionTypeService;
    @Autowired
    private TestUserService testUserService;

    // 1.List
    @GetMapping
    public ModelAndView getListPage(@RequestParam(value = "search", defaultValue = "") String search,
                                    @RequestParam(value = "typeId", defaultValue = "0") Long typeId,
                                    @RequestParam(value = "propSelected", defaultValue = "") String propSelected
                                  ) {
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE);
        List<Question> eList = new ArrayList<>();

        if ("".equals(search) && typeId == 0) {
            // (1) show all
            eList = questionService.findAll();
        } else if ("".equals(search) && typeId != 0) {
            // (2) show by type (attr = object)
            eList = questionTypeService.findById(typeId).getQuestionList();
            modelAndView.addObject("typeSelected", questionTypeService.findById(typeId));
        } else if(!("".equals(search)) && typeId == 0) {
            eList = questionService.findByTitle(search);
        } else if(!("".equals(search)) && typeId != 0){
            List<Question> questions = questionTypeService.findById(typeId).getQuestionList();
            modelAndView.addObject("typeSelected", questionTypeService.findById(typeId));
            for (Question question : questions){
                if (question.getTitle().contains(search)){
                    eList.add(question);
                }
            }
        } else {}

        modelAndView.addObject("eList", eList);
        modelAndView.addObject("search", search);
        modelAndView.addObject("typeId", typeId);
        modelAndView.addObject("propSelected", propSelected);
        modelAndView.addObject("questionTypeList", questionTypeService.findAll());
        modelAndView.addObject("testUserList", testUserService.findAll());

        // add new on modal for CREATE and EDIT
        modelAndView.addObject("question", new Question()); // create
        modelAndView.addObject("questionEdit", new Question()); // edit
        return modelAndView;
    }

    // 2.Create
    @PostMapping("/create")
    public ModelAndView getCreated(@Validated @ModelAttribute("question") Question question,
                                   @RequestParam(value = "search", defaultValue = "") String search,
                                   @RequestParam(value = "typeId", defaultValue = "0") Long typeId,
                                   @RequestParam(value = "propSelected", defaultValue = "") String propSelected,
                                   RedirectAttributes redirect) {

            questionService.save(question);
            ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
            redirect.addFlashAttribute("msg", CREATE_MSG);
            return modelAndView;
    }

    // 3.Edit --> studentEdit
    @PostMapping("/edit")
    public ModelAndView getEdited(@Validated @ModelAttribute("questionEdit") Question question,
                                  @RequestParam(value = "search", defaultValue = "") String search,
                                  @RequestParam(value = "typeId", defaultValue = "0") Long typeId,
                                  @RequestParam(value = "propSelected", defaultValue = "") String propSelected,
                                  RedirectAttributes redirect) {
            questionService.save(question);
            ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
            redirect.addFlashAttribute("msg", EDIT_MSG);
            return modelAndView;
    }

    // 4. Delete
    @PostMapping("/delete")
    public ModelAndView getDeleted(@RequestParam("questionId") long questionId,
                                   RedirectAttributes redirect) {
        questionService.remove(questionId); //
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        redirect.addFlashAttribute("msg", DELETE_MSG);
        return modelAndView;
    }

//    // 5.View
//    @GetMapping("/view/{id}")
//    public ModelAndView getViewPage(@PathVariable(value = "id") long id) {
//        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
//        modelAndView.addObject("question", questionService.findById(id));
//        return modelAndView;
//    }

    // 6. Disable/available
    @PostMapping("/setStatus")
    public ModelAndView turnCustomerOnOff(@RequestParam("questionId") Long[] questionId,
                                          RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_LIST);
        Question question = null;
        for (Long id : questionId){
            question = questionService.findById(id);
            if(question != null) {
                questionService.remove(id);
            }
        }
        redirectAttributes.addFlashAttribute("msg", DELETE_MANY_MSG);
        return modelAndView;
    }
}
