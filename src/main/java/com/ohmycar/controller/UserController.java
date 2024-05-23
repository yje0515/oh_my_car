package com.ohmycar.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ohmycar.domain.AuthVO;
import com.ohmycar.domain.CarVO;
import com.ohmycar.domain.UserDAO;
import com.ohmycar.domain.UserVO;
import com.ohmycar.service.CarService;
import com.ohmycar.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
@Log4j
public class UserController {

	private final UserService userService;
	private final CarService carService;
	private final UserDAO userDAO;
	private final PasswordEncoder passwordEncoder;

<<<<<<< Updated upstream
=======
	private static final String RESULT_STRING = "result";

>>>>>>> Stashed changes
	// 회원가입페이지로 이동
	@GetMapping("/join")
	public void joinGet() {
		log.info("join.....");

	}

	// 회원가입
	@PostMapping("/join")
	public String joinPost(UserVO userVO, AuthVO authVO) {
		userService.joinUser(userVO, authVO);
		log.info("success join.....");
		return "redirect:/user/login";
	}

	// 관리자권한 가진 사용자만 접근 가능
	@GetMapping("/admin")
	public void adminGet(Model model) {
		log.info("admin.....");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
		model.addAttribute("userVO",userVO);

	}

<<<<<<< Updated upstream
	// 회원가입시 아이디 중복확인
	@RequestMapping("/idDupCheck")
	@ResponseBody
	public String idCheckPost(@RequestParam("userId") String userId) {
		if (userService.joinIdCheck(userId) != null) {
			return "fail";
		} else {
			return "success";
		}
	}

	// 회원가입시 이메일 중복확인
	@RequestMapping("/emailDupCheck")
	@ResponseBody
	public String emailCheckPost(@RequestParam("email") String email) {
		String result = "";
		if (userService.joinEmailCheck(email) != null) {
			result = "fail";
		} else {
			result = "success";
		}
		return result;
	}

	// 로그인 ajax로 회원존재여부 확인...
	@RequestMapping("/loginCheck")
	@ResponseBody
	public String loginCheckPost(@RequestParam("userId") String userId, @RequestParam("password") String password) {
		String result = "";

		UserVO userVO = userService.getUserByUserId(userId);
		if (userVO == null) {
			log.info("User not found");
			return "fail";
		}

		// userVO가 null이 아닌 경우(id가 존재하는 경우)
		boolean pwdCheck = passwordEncoder.matches(password, userVO.getPassword());
		if (pwdCheck) {
			result = "success";
		} else {
			result = "fail";
		}
		log.info("Login " + result + ".....");

		return result;
	}

	// 마이페이지로 이동
=======
	/**
	 * 마이페이지로 이동하는 함수
	 * 
	 * @return userVO 에는 유저 정보가 나가고
	 * @return carList 에는 자동차 정보들이 나간다.
	 */
>>>>>>> Stashed changes
	@GetMapping("/mypage")
	public void mypageGet(Model model) {
		UserVO userVO = userDAO.getUser();
		model.addAttribute("userVO", userVO);
		List<CarVO> carList = carService.getCarsByUserId(userVO.getUserId());
		model.addAttribute("carList", carList);

		log.info("mypage....");
	}

	// 비밀번호 확인 페이지로 이동
	@GetMapping("/passwordCheck")
	public void passwordCheckGet() {
<<<<<<< Updated upstream

=======
		log.info("passwordCheckGet");
>>>>>>> Stashed changes
	}

	// 비밀번호 확인 후 각각 페이지로 Redirect
	@PostMapping("/passwordCheck")
	public String passwordCheckPost(String password, String action, RedirectAttributes rttr) {
<<<<<<< Updated upstream
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		/* if (authentication.getPrincipal() instanceof UserDetails) { */
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserVO userVO = userService.getUserByUserId(userDetails.getUsername());
=======
		UserVO userVO = userDAO.getUser();
>>>>>>> Stashed changes
		// 비밀번호 확인
		String realPwd = userService.userPasswordCheckByUserId(userVO.getUserId());
		boolean pwdChecked = passwordEncoder.matches(password, realPwd);

		// 비밀번호가 맞으면
		if (pwdChecked) {
			log.info("correctPassword.....");
			//비밀번호 확인 후 접근 가능
			rttr.addFlashAttribute("passwordChecked", "ok");
			if ("edit".equals(action)) {
				// 회원정보수정
				return "redirect:/user/userUpdate";
			} else {
				// 회원탈퇴
				return "redirect:/user/userDelete";
			}
		}

		// 비밀번호가 틀리면
		//비밀번호 확인 후 접근 가능
		rttr.addFlashAttribute("passwordChecked", "notYet");
		log.info("wrongPassword.....");
<<<<<<< Updated upstream
		rttr.addFlashAttribute("result", "wrongPassword");
=======
		rttr.addFlashAttribute(RESULT_STRING, "wrongPassword");
>>>>>>> Stashed changes
		if ("edit".equals(action)) {
			// action값 가지고 비밀번호 재확인
			return "redirect:/user/passwordCheck?action=edit";
		} else {
			return "redirect:/user/passwordCheck?action=remove";
		}

	}

	// 회원정보수정페이지로 이동
	@GetMapping("/userUpdate")
	public void userUpdateGet(Model model) {
		UserVO userVO = userDAO.getUser();
		model.addAttribute("userVO", userVO);

		log.info("update...");
	}

	// 회원정보 수정
	@PostMapping("/userUpdate")
	public String userUpdatePost(UserVO userVO, RedirectAttributes rttr) {
		userService.updateUser(userVO);

		// 회원정보 수정시 alert
<<<<<<< Updated upstream
		rttr.addFlashAttribute("result", "success");
=======
		rttr.addFlashAttribute(RESULT_STRING, "success");
>>>>>>> Stashed changes

		return "redirect:/";
	}

	// 회원탈퇴페이지로 이동
	@GetMapping("/userDelete")
	public void userDeleteGet(Model model) {
		log.info("delete.....");
	}

	// 회원탈퇴
	@PostMapping("/userDelete")
	public String userDeleteGet(RedirectAttributes rttr) {
		UserVO userVO = userDAO.getUser();
		userService.deleteUser(userVO.getUserId());

		// 로그아웃처리
		SecurityContextHolder.clearContext();

<<<<<<< Updated upstream
		rttr.addFlashAttribute("result", "deleteSuccess");
=======
		rttr.addFlashAttribute(RESULT_STRING, "deleteSuccess");
>>>>>>> Stashed changes

		return "redirect:/";
	}

}
