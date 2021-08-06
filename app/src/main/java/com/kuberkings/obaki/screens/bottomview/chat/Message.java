package com.kuberkings.obaki.screens.bottomview.chat;


    public class Message {
        int Image;
        String Name;
        String lastMessage;
        String time;
        String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        int count;

        public int getImage() {
            return Image;
        }

        public void setImage(int image) {
            Image = image;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getLastMessage() {
            return lastMessage;
        }

        public void setLastMessage(String lastMessage) {
            this.lastMessage = lastMessage;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Message(int image, String name, String lastMessage, int count, String time,String status) {
            Image = image;
            Name = name;
            this.lastMessage = lastMessage;
            this.count = count;
            this.time = time;
            this.status=status;
        }
    }
