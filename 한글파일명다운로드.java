String agent = request.getHeader("User-Agent");

    String real_file_nam = "한글파일테스트.mp4";

		//Internet Explore
		if(agent.contains("Trident")){
			real_file_nam = URLEncoder.encode(real_file_nam, "UTF-8").replaceAll("\\+", " ");
		}
		//Micro Edge
        else if(agent.contains("Edge")){ 
        	real_file_nam = URLEncoder.encode(real_file_nam, "UTF-8");
        }
		//Chrome
        else {
        	real_file_nam = new String(real_file_nam.getBytes("UTF-8"), "ISO-8859-1");
        }

		response.setContentType("application/octet-stream; charset=UTF-8"); 
		response.setHeader("Content-Description", "file download"); 
		response.setHeader("Content-Disposition", "attachment; filename="+real_file_nam); 
		response.setHeader("Content-Transfer-Encoding", "binary");

		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(fullPath);
			//fileCopyUtis 사용시 4096 사이즈 버퍼
			FileCopyUtils.copy(fis, out);
		} catch(Exception e){
		    e.printStackTrace();
		}finally{
		    if(fis != null){
		        try{
		            fis.close();
		        }catch(Exception e){
		         e.printStackTrace();
		        }
		    }
		    if(out != null) {
		     out.flush();
		    }
		}
