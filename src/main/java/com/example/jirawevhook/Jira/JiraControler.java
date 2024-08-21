package com.example.jirawevhook.Jira;

import com.example.jirawevhook.Jira.API.JiraWebhookRequestBody;
import com.example.jirawevhook.Jira.API.PolicyRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@RestController
@RequestMapping("/webhook")
public class JiraControler {



    @PostMapping
    public void recieveCompletedIssue(@RequestBody JiraWebhookRequestBody requestBody){
        System.out.println(requestBody);
        System.out.println(requestBody.getIssueKey());
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println(LocalDateTime.now().format(formato));
        if("Done".equalsIgnoreCase(requestBody.getIssueStatus())) System.out.println("Completed Issue");
    }

    @PostMapping("/request")
    public void recieveCompletedRequest(@RequestBody PolicyRequest recievedRequest){
        System.out.println(recievedRequest);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(LocalDateTime.now().format(formato));
    }
}
