package com.curse.shared.domain.validators;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.curse.business.clientes.control.ClientService;
import com.curse.business.clientes.dto.ClientNewDto;
import com.curse.business.clientes.entity.Client;
import com.curse.shared.domain.errors.FieldMessage;
import com.curse.shared.helpers.DocumentUtil;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDto> {

    @Autowired
    private ClientService clienteService;

    @Override
    public void initialize(ClientInsert ann) {

    }

    @Override
    public boolean isValid(ClientNewDto objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getType() == null) {
            list.add(new FieldMessage("type", "Tipo não pode ser nulo"));
        }

        if (objDto.getDocument() == null) {
            return false;
        }

        String document = objDto.getDocument();

        if (document.length() < 11 || document.length() > 14) {
            list.add(new FieldMessage("document", "Documento inválido"));
        }

        if (document.length() == 11 && !DocumentUtil.isValidCPF(document)) {
            list.add(new FieldMessage("document", "CPF inválido"));
        }

        if (document.length() == 14 && !DocumentUtil.isValidCNPJ(document)) {
            list.add(new FieldMessage("document", "CNPJ inválido"));
        }

        if (objDto.getEmail() == null) {
            return false;
        }

        Client existsClient = this.clienteService.findbyEmail(objDto.getEmail());

        if (existsClient != null) {
            list.add(new FieldMessage("email", "Email já cadastrado"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }

        return list.isEmpty();
    }
}