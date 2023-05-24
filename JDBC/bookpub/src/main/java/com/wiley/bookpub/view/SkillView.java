package com.wiley.bookpub.view;

import java.util.Scanner;

import com.wiley.bookpub.controller.SkillController;

public class SkillView {

	public static void addSkill() {
		Scanner scan = new Scanner(System.in);
		
		//while(true)
			// take all inputs
		
		SkillController scCtrl = new SkillController();
		
		int result = scCtrl.addSkill(0, null, 0, null, 0);
		
//		if result
//			return your message
	}
}