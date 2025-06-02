package com.example.lab4.Controller;

import com.example.lab4.Entity.Bai2.Stafff;
import com.example.lab4.Entity.Staff;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class StaffController {
    @RequestMapping("/staff/create/form")
    public String createForm(Model model, @ModelAttribute("staff") Staff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "demo/staff-create";
    }

    @RequestMapping("/staff/create/save")
    public String createSave(Model model, @ModelAttribute("staff") Staff staff,
                             @RequestPart("photo_file") MultipartFile photoFile) {
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }
        model.addAttribute("message", "Xin chào " + staff.getFullname());
        return "demo/staff-create";
    }
    @RequestMapping("/staff/create/from-bai2")
    public String fromBai2(Model model, @ModelAttribute("stafff") Stafff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "demo/staff-validatee";
    }

    @RequestMapping("/staff/create/save-bai2")
    public String createSave(Model model,
                             @RequestPart("photo_file") MultipartFile photoFile,
                             @Valid @ModelAttribute("stafff") Staff staff, Errors errors) {
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
        }
        return "demo/staff-validatee";
    }

}
