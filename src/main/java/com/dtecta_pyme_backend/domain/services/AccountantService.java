package com.dtecta_pyme_backend.domain.services;

import com.dtecta_pyme_backend.domain.model.entities.Accountant;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.CreateAccountantResource;
import com.dtecta_pyme_backend.interfaces.rest.resources.accountant.UpdateAccountantResource;

import java.util.List;

public interface AccountantService {
    List<Accountant> getAll();
    Accountant create(CreateAccountantResource resource);
    Accountant update(Long accountantId, UpdateAccountantResource resource);
    void delete(Long accountantId);
}
