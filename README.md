Tutor



## git dev 分支的操作

1. 创建远程`origin`的`dev`分支到本地

   ```bash
   $ git checkout -b dev origin/dev
   ```

2. 先进行pull操作，和远程同步

   ```bash
   $ git pull origin dev
   ```

3. 就可以在dev上做提交

   ```bash
   $ git add env.txt
   
   $ git commit -m "add env"
   [dev 7a5e5dd] add env
    1 file changed, 1 insertion(+)
    create mode 100644 env.txt
   
   # 注意此时push到的是dev
   $ git push origin dev
   Counting objects: 3, done.
   Delta compression using up to 4 threads.
   Compressing objects: 100% (2/2), done.
   Writing objects: 100% (3/3), 308 bytes | 308.00 KiB/s, done.
   Total 3 (delta 0), reused 0 (delta 0)
   To github.com:michaelliao/learngit.git
      f52c633..7a5e5dd  dev -> dev
   ```

   
