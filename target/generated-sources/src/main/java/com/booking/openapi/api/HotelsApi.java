/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.11.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.booking.openapi.api;

import com.booking.openapi.model.ErrorDto;
import com.booking.openapi.model.HotelBrief;
import com.booking.openapi.model.HotelDetail;
import com.booking.openapi.model.NewHotel;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-19T11:27:53.123989100+03:00[Europe/Moscow]", comments = "Generator version: 7.11.0")
@Validated
@Tag(name = "AmenitiesController", description = "the AmenitiesController API")
public interface HotelsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /hotels/{id}/amenities : Add amenities to a hotel
     *
     * @param id ID of the hotel (required)
     * @param requestBody  (required)
     * @return Amenities added successfully (status code 204)
     *         or Bad Request (status code 400)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "addHotelAmenities",
        summary = "Add amenities to a hotel",
        tags = { "AmenitiesController" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Amenities added successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/hotels/{id}/amenities",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> addHotelAmenities(
        @Parameter(name = "id", description = "ID of the hotel", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
        @Parameter(name = "request_body", description = "", required = true) @Valid @RequestBody List<String> requestBody
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
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
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"errorMessage\" : \"Resource not found.\", \"errorCode\" : 404, \"timestamp\" : \"2023-10-05T14:48:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /hotels : Create a new hotel
     *
     * @param newHotel  (required)
     * @return Hotel created successfully (status code 201)
     *         or Bad Request (status code 400)
     *         or Conflict (status code 409)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "createHotel",
        summary = "Create a new hotel",
        tags = { "HotelController" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Hotel created successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = HotelBrief.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "409", description = "Conflict", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/hotels",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<HotelBrief> createHotel(
        @Parameter(name = "NewHotel", description = "", required = true) @Valid @RequestBody NewHotel newHotel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"address\" : \"address\", \"phone\" : \"phone\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"brand\" : \"brand\" }";
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
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"errorMessage\" : \"Resource not found.\", \"errorCode\" : 404, \"timestamp\" : \"2023-10-05T14:48:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /hotels/{id} : Get detailed information about a specific hotel
     *
     * @param id ID of the hotel (required)
     * @return Detailed information about a hotel (status code 200)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getHotelById",
        summary = "Get detailed information about a specific hotel",
        tags = { "HotelController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Detailed information about a hotel", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = HotelDetail.class))
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
        value = "/hotels/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<HotelDetail> getHotelById(
        @Parameter(name = "id", description = "ID of the hotel", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"amenities\" : [ \"Free WiFi\", \"Parking\" ], \"address\" : { \"country\" : \"Los Angeles Country\", \"city\" : \"Los Angeles\", \"street\" : \"Main St\", \"houseNumber\" : 123, \"postCode\" : \"90001\" }, \"arrivalTime\" : { \"checkIn\" : \"15:00\", \"checkOut\" : \"11:00\" }, \"name\" : \"Hotel California\", \"id\" : 0, \"brand\" : \"California Hotels\", \"contacts\" : { \"phone\" : \"+1-800-555-0123\", \"email\" : \"contact@hotelcalifornia.com\" } }";
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


    /**
     * GET /hotels : Get a list of all hotels
     *
     * @param page The page number to retrieve (default is 0) (optional, default to 0)
     * @param size The number of items to retrieve per page (default is 10) (optional, default to 10)
     * @return A list of hotels with brief information (status code 200)
     *         or Bad Request if the parameters are invalid (status code 400)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getHotels",
        summary = "Get a list of all hotels",
        tags = { "HotelController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A list of hotels with brief information", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = HotelBrief.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request if the parameters are invalid", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/hotels",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<HotelBrief>> getHotels(
        @Parameter(name = "page", description = "The page number to retrieve (default is 0)", in = ParameterIn.QUERY) @Valid @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
        @Parameter(name = "size", description = "The number of items to retrieve per page (default is 10)", in = ParameterIn.QUERY) @Valid @RequestParam(value = "size", required = false, defaultValue = "10") Integer size
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
