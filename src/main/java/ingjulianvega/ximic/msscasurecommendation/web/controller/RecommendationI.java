package ingjulianvega.ximic.msscasurecommendation.web.controller;

import ingjulianvega.ximic.msscasurecommendation.web.model.ApiError;
import ingjulianvega.ximic.msscasurecommendation.web.model.Recommendation;
import ingjulianvega.ximic.msscasurecommendation.web.model.RecommendationDto;
import ingjulianvega.ximic.msscasurecommendation.web.model.RecommendationList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface RecommendationI {

    @Operation(summary = "Endpoint to get the list of recommendations", description = "Returns a list of recommendation", tags = {"recommendation"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = RecommendationList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<RecommendationList> get();

    @Operation(summary = "Endpoint to get the information of a recommendation given the id", description = "Returns a recommendation", tags = {"recommendation"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = RecommendationDto.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<RecommendationDto> getById(@Parameter(in = ParameterIn.PATH, description = "The recommendation id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);

    @Operation(summary = "Endpoint to get the list of recommendations having the visitId", description = "Returns a list of recommendation for a visit", tags = {"recommendation"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = RecommendationList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/visit-id/{visit-id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<RecommendationList> getByVisittId(@Parameter(in = ParameterIn.PATH, description = "The visit id", required = true, schema = @Schema()) @NotNull @PathVariable("visit-id") UUID visitId);

    @Operation(summary = "Endpoint to create a recommendation", description = "Creates a new recommendation", tags = {"recommendation"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> create(@Parameter(in = ParameterIn.DEFAULT, description = "recommendation's attributes", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Recommendation recommendation);

    @Operation(summary = "Endpoint to update the information of a recommendation given the id", description = "Updates a recommendation", tags = {"recommendation"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateById(@Parameter(in = ParameterIn.PATH, description = "The recommendation id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id,
                                    @Parameter(in = ParameterIn.DEFAULT, description = "recommendation's attributes", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Recommendation recommendation);


    @Operation(summary = "Endpoint to delete a recommendation", description = "Deletes a recommendation", tags = {"recommendation"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteById(@Parameter(in = ParameterIn.PATH, description = "The recommendation id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);

}
