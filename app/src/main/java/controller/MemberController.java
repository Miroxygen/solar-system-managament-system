package controller;

import model.Member;
import model.MemberList;
import view.View.editMemberChoices;

public class MemberController {
    private view.View memberUI = new view.View();
    private model.MemberList memberList = new MemberList();


    public model.Member findMemberByname(String memberName) {
        for(Member m : memberList.getMembers()) {
            if(m.getName().equals(memberName)) {
                return m;
            } 
        }
        return null;
    }

    public void showMemberList() {
        memberUI.showMemberList(memberList);
    }

    public void createMember() {
        try {
            model.Member newMember = memberUI.createMember();
            duplicatePhoneNumberCheck(newMember.getPhoneNumber());
            duplicateEmailCheck(newMember.getEmail());
            memberList.addMember(newMember);
            memberUI.showMember(newMember);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            createMember();
        }
    }

    public void duplicatePhoneNumberCheck(String phoneNumber) throws Exception {
        for(Member m : memberList.getMembers()) {
            if(m.getPhoneNumber().equals(phoneNumber)) {
                throw new Exception("Invalid phonenumber");
            } 
        }
    }
    
    public void duplicateEmailCheck(String email) throws Exception {
        for(Member m : memberList.getMembers()) {
            if(m.getEmail().equals(email)) {
                throw new Exception("Invalid email");
            } 
        }
    }

    public void deleteMember(Member selectedMember) {
        String deleteAnswer = memberUI.deleteMember(selectedMember);
        if(deleteAnswer.equals("Y") || deleteAnswer.equals("y")) {
            memberList.deleteMember(selectedMember);
            selectedMember = null;
            memberUI.succesfulAction();
        } else {
            return;
        }
    }

    public void editName(Member selectedMember) {
        String newName = memberUI.newName();
        selectedMember.setName(newName);
    }

    public void editPhoneNumber(Member selectedMember) {
        String newPhoneNumber = memberUI.newPhoneNumber();
        try {
            duplicatePhoneNumberCheck(newPhoneNumber);
            selectedMember.setPhoneNumber(newPhoneNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editEmail(Member selectedMember) {
        String newEmail = memberUI.newEmail();
        try {
            duplicateEmailCheck(newEmail);
            selectedMember.setEmail(newEmail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}