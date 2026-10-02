package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ResourceService {
	private final ResourceRepository resourceRepository;

	public ResourceService(ResourceRepository resourceRepository) {
		this.resourceRepository = resourceRepository;
	}

	//Resourceの一覧を返す
	public List<Resource> findAll() {
		return resourceRepository.findAll();
	}

	//Resourceの新規作成　同一の名前、名前の無記入は禁止
	public Resource createNewResource(Resource newResource) {
		String newName = newResource.getName();
		if (newName == null || newName.isEmpty()) {
			return null;
		}
		if(resourceRepository.findByName(newName).isPresent()) {
			return null;
		}
		return resourceRepository.save(newResource);
	}

	//Resourceの削除(Idから)
	public List<Resource> deleteResourceById(Long id) {
		if (resourceRepository.findById(id).isEmpty()) {
			return null;
		}
		resourceRepository.deleteById(id);
		return findAll();
	}

}
