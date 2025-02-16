/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.11.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.booking.openapi.api;

import com.booking.openapi.model.ErrorDto;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.HotelSearchCriteriaDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-16T17:19:33.206639900+03:00[Europe/Moscow]", comments = "Generator version: 7.11.0")
@Validated
@Tag(name = "SearchController", description = "the SearchController API")
public interface SearchApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /search : Search hotels by various parameters
     *
     * @param hotelSearchCriteriaDTO  (required)
     * @return A list of hotels matching the search criteria (status code 200)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "searchHotels",
        summary = "Search hotels by various parameters",
        tags = { "SearchController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of hotels matching the search criteria", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = HotelBrief.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/search",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<List<HotelBrief>> searchHotels(
        @Parameter(name = "HotelSearchCriteriaDTO", description = "", required = true) @Valid @RequestBody HotelSearchCriteriaDTO hotelSearchCriteriaDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"address\" : \"address\", \"phone\" : \"phone\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"brand\" : \"brand\" }, { \"address\" : \"address\", \"phone\" : \"phone\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"brand\" : \"brand\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"errorMessage\" : \"Resource not found.\", \"errorCode\" : 404, \"timestamp\" : \"2023-10-05T14:48:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"errorMessage\" : \"Resource not found.\", \"errorCode\" : 404, \"timestamp\" : \"2023-10-05T14:48:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
