FROM gradle:jdk11

COPY --chown=gradle:gradle . /developer_test_server
WORKDIR /developer_test_server

CMD ["gradle", "--no-daemon", "build"]
