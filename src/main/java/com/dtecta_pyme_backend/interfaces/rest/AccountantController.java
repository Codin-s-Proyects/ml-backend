package com.dtecta_pyme_backend.interfaces.rest;

import com.dtecta_pyme_backend.domain.model.entities.Accountant;
import com.dtecta_pyme_backend.domain.services.AccountantService;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.AccountantResource;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.CreateAccountantResource;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.UpdateAccountantResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
@RestController
@RequestMapping(value = "/api/v1/accountant", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Accountant", description = "Accountant Management Endpoints")
public class AccountantController {

    private final AccountantService accountantService;

    public AccountantController(AccountantService accountantService) {
        this.accountantService = accountantService;
    }

    @GetMapping()
    ResponseEntity<List<AccountantResource>> getAllAccountant() {
        List<AccountantResource> accountantResources = accountantService.getAll()
                .stream().map(this::mapEntityToResource)
                .toList();

        return new ResponseEntity<>(accountantResources, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<AccountantResource> createAccountant(@RequestBody CreateAccountantResource resource) {
        Accountant accountant = accountantService.create(resource);

        return new ResponseEntity<>(mapEntityToResource(accountant), HttpStatus.CREATED);
    }

    @PutMapping("/{accountantId}")
    ResponseEntity<AccountantResource> updateAccountant(@RequestBody UpdateAccountantResource resource, @PathVariable Long accountantId) {
        Accountant accountant = accountantService.update(accountantId, resource);

        return new ResponseEntity<>(mapEntityToResource(accountant), HttpStatus.CREATED);
    }

    @DeleteMapping("/{accountantId}")
    ResponseEntity<?> deleteAccountant(@PathVariable Long accountantId) {
        accountantService.delete(accountantId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private AccountantResource mapEntityToResource(Accountant accountant) {
        return new AccountantResource(accountant.getId(), accountant.getDni());
    }
}
