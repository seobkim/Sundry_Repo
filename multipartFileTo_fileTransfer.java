MultipartFile excelFile =request.getFile("excelFile");

String storePathString = propertiesService.getString("Globals.fileStorePath");
	        File destFile = new File(storePathString + excelFile.getOriginalFilename());
	        // 해당 폴더가 있는지 체크
	        if (!destFile.exists() || destFile.isFile()) {
	        	destFile.mkdirs();
	        }
	        try{
	            excelFile.transferTo(destFile);

	        }catch( IOException e){
	            throw new RuntimeException(e.getMessage(),e);
	        }
