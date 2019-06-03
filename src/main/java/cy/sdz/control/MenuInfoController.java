package cy.sdz.control;

import cy.sdz.dto.MenuDto2;
import cy.sdz.dto.MenuInfoDto;
import cy.sdz.pojo.UserInfo;
import cy.sdz.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuInfoController {
    @Autowired
    MenuInfoService menuInfoService;

    /*

    @RequestMapping("getAllMenuInfo")
    public Object getAllMenuInfo(@RequestParam int roleId){
        ArrayList<MenuInfoDto> menuInfoDtoArrayList = new ArrayList<MenuInfoDto>();
        MenuInfoDto menuInfoDto = new MenuInfoDto();
        menuInfoDto.setId(1);
        menuInfoDto.setPid(0);
        menuInfoDto.setSeqno(1);
        menuInfoDto.setName("F1");
        menuInfoDto.setUrl("");
        MenuInfoDto childOne = new MenuInfoDto();
        childOne.setId(2);
        childOne.setPid(1);
        childOne.setSeqno(0);
        childOne.setName("C1");
        childOne.setUrl("aaa.html");
        MenuInfoDto childTwo = new MenuInfoDto();
        childTwo.setId(2);
        childTwo.setPid(1);
        childTwo.setSeqno(0);
        childTwo.setName("C2");
        childTwo.setUrl("aab.html");
        MenuInfoDto childThree = new MenuInfoDto();
        childThree.setId(3);
        childThree.setPid(1);
        childThree.setSeqno(0);
        childThree.setName("C3");
        childThree.setUrl("aac.html");
        ArrayList<MenuInfoDto> children = new ArrayList<MenuInfoDto>();
        children.add(childOne);
        children.add(childTwo);
        children.add(childThree);
        menuInfoDto.setChildren(children);
        menuInfoDtoArrayList.add(menuInfoDto);
        return menuInfoDtoArrayList;
    }*/



    @RequestMapping("listMenu")
    public Object listMenu(@RequestParam int roleId){
        List<MenuInfoDto> menuInfoList = menuInfoService.listMenu(roleId);
        return menuInfoList;
    }

    @RequestMapping("listMenuByUserId")
    public Object listMenuByUserId(HttpSession httpSession){
        UserInfo userInfo = (UserInfo)httpSession.getAttribute("userInfo");
        int userId = userInfo.getUserId();
        List<MenuInfoDto> menuInfoDtoList = menuInfoService.listMenuByUserId(userId);
        return menuInfoDtoList;
    }

    @RequestMapping("addMenu")
    public boolean addMenuId(@RequestBody MenuDto2 menuDto){
        return menuInfoService.insertMenu(menuDto);

    }

    @RequestMapping("deleteMenu")
    public boolean deleteMenu(@RequestParam int roleId){
        return menuInfoService.deleteMenu(roleId);
    }



}
