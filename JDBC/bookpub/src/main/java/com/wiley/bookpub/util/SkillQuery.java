package com.wiley.bookpub.util;

public class SkillQuery {
	public static String addSkill = "INSERT INTO stillstore VALUES(?, ?, ?, ?, ?)";
	public static String viewAllSkills = "SELECT * FROM stillstore ORDER BY book_name";
}