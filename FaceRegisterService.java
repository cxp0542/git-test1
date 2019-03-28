

    @Override
    public Response handle(Request request) throws Exception
    {
        return new ResponseBody()
                .setStatus(ResponseStatus.STATUS_SUCCESS)
                .putData("instance", faceRegisterManager.faceRegister(faceRegisterVo.get().getFace(),
                        faceRegisterVo.get().getGroupId(),
                        faceRegisterVo.get().getUserId()))
                .bulid();
    }

}
