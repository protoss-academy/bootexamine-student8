package com.protosstechnology.train.bootexamine.controller;

import com.protosstechnology.train.bootexamine.document.CreateRequest;
import com.protosstechnology.train.bootexamine.document.UpdateRequest;
import com.protosstechnology.train.bootexamine.models.Document;
import com.protosstechnology.train.bootexamine.repository.DocumentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Log4j2
@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public Document getDocument(Integer id) {
        Optional<Document> byId = documentRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        else {
            return null;
        }
    }

    public Document updateDocument(UpdateRequest request) {
        Optional<Document> byId = documentRepository.findById(request.getId());
        try {
            if (byId.isPresent()) {
                Document documentUpdate = byId.get();
                documentUpdate.setDocumentNumber(request.getDocumentNumber());
                documentUpdate.setDescription(request.getDescription());
                documentUpdate = documentRepository.save(documentUpdate);
                return documentUpdate;
            }
            else {
                return null;
            }
        } catch (Exception e) {
            log.error("Could not Update Document ID {} because {}", request.getId(), e.getCause());
            return null;
        }

    }

    public Boolean deleteDocument(Integer id) {
        Optional<Document> byId = documentRepository.findById(id);
        try {
            if (byId.isPresent()) {
                documentRepository.deleteById(id);
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            log.error("Could not Delete Document ID {} because {}", id, e.getCause());
            return false;
        }

    }

    public Document createDocument(CreateRequest request) {
        try {
            Document document = new Document();
            document.setDescription(request.getDescription());
            document.setDocumentNumber(request.getDocumentNumber());
            return documentRepository.save(document);
        } catch (Exception e) {
            log.error("Could not create Document {}", e.getCause());
            return null;
        }
    }
}
