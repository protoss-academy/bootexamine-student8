package com.protosstechnology.train.bootexamine.repository;

import com.protosstechnology.train.bootexamine.models.Document;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DocumentRepository extends PagingAndSortingRepository<Document, Integer> {
}
