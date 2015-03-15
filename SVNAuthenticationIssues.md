# Introduction #

The mystery of the failing Authentication when committing changes to the repository.
My teammates were not able to commit changes because their authentication failed.  I started having the same problem, however only after I had copied the working copy of the files to another drive.  After checking out a new copy on my machine at work, I had no problems committing, updating or checking out.

Given this, I assume that svn does not like having the location of its working copy moved without its knowing. Reading in the manual, there is a copy/move function that will keep all updates in svn current.  So having the working copy on a removable media might not be the ideal situation as the drive letters can change.

There was one weird thing to **note**:  When I pasted the URL to the svn location, I had to authenticate multiple times in order to see the repository contents.  Does one have to authenticate through each level of folders?