package com.example.jirawevhook.Jira.API;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Policy Request to check compliance and create JIRA tickets")
public class PolicyRequest {

    @Size(max = 255)
    @Schema(description = "Data elements", example = "[\"Accelerator Pedal Percent\"]")
    Set<@Size(max = 255) @Pattern(regexp = "^.{0,255}$") String> dataElements;

    @Size(max = 255)
    @Schema(description = "Purposes of use", example = "[\"Compliance\"]")
    Set<@Size(max = 255) @Pattern(regexp = "^.{0,255}$") String> purposes;

    @Schema(description = "Whether the data is Ford or Customer owned", example = "true")
    Boolean fordOwned;

    @Schema(description = "Expiration date of the policy in ISO format", example = "2023-12-31", maxLength = 10)
    LocalDate expirationDate;

    @Schema(description = "Whether the data is shared with third parties or not", example = "false")
    Boolean thirdPartyShared;

    @Schema(description = "Whether the offboarding method is DCP or not", example = "true")
    Boolean dcpOffboarding;

    @Size(max = 255)
    @Pattern(regexp = "^.{0,255}$")
    @Schema(description = "Architecture of the vehicle", example = "FNV4")
    String vehicleArchitecture;

    @Min(1)
    @Max(Long.MAX_VALUE)
    @Schema(description = "Client request number", example = "123")
    Long clientRequestNo;

    @Size(max = 2)
    @Schema(description = "Markets", example = "[\"NA\"]")
    Set<@Size(max = 2) @Pattern(regexp = "(?i)NA|EU") String> markets;
}
