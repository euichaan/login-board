package tennis.practice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tennis.practice.dto.MemberSaveForm;
import tennis.practice.service.MemberService;

@Slf4j
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/signUp")
  public String SignUpForm(Model model) {
    model.addAttribute("form", new MemberSaveForm());
    return "/members/signUpForm";
  }

  @PostMapping("/memberSave")
  public String memberAdd(@Validated @ModelAttribute("form") MemberSaveForm form,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      log.info("errors = {}", bindingResult);
      return "/members/signUpForm";
    }

    memberService.memberAdd(form);

    return "redirect:/";
  }

}
