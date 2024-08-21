package com.example.jirawevhook.Jira.API;


import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JiraWebhookRequestBody {

    @Nullable
    private String rule;

    private String issueKey;

    private String issueStatus;
}
