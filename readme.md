# Dive into MongoDB and Redis interaction

Social network with where users can post messages to channels. Posts can be commented.
Each user can create own channels and subscribe on other user's channels. 
There is feed, where user can see posts from all channels one subscribed on.

- Horizontally scalable application may run in multiple instances
- Using migration tool Mongock for MongoDB changes

TODO:  
- [x] MongoDB in docker  
- [x] Create DB on container start up
- [x] Mongo collections creation migrations
- [ ] User CRUD
- [ ] Create users with different schema versions
- [ ] Post CRUD
- [ ] Channel CRUD
