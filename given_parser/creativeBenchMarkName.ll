type %struct.node = {i32, %struct.node*};
define %struct.node @buildList()
{
	%input = alloca i32
	%i = alloca i32
	%n0 = alloca %struct.node*
	%n1 = alloca %struct.node*
	%n2 = alloca %struct.node*
	%n3 = alloca %struct.node*
	%n4 = alloca %struct.node*
	%n5 = alloca %struct.node*
buildList1:
buildList1:
	%u0 = call i8* malloc(8)
	%u1 = BITCAST i8* %u0 to %struct.node
	%u2 = load * %n0
	store %u1 %struct.node, %u2* 
	%u3 = call i8* malloc(8)
	%u4 = BITCAST i8* %u3 to %struct.node
	%u5 = load * %n1
	store %u4 %struct.node, %u5* 
	%u6 = call i8* malloc(8)
	%u7 = BITCAST i8* %u6 to %struct.node
	%u8 = load * %n2
	store %u7 %struct.node, %u8* 
	%u9 = call i8* malloc(8)
	%u10 = BITCAST i8* %u9 to %struct.node
	%u11 = load * %n3
	store %u10 %struct.node, %u11* 
	%u12 = call i8* malloc(8)
	%u13 = BITCAST i8* %u12 to %struct.node
	%u14 = load * %n4
	store %u13 %struct.node, %u14* 
	%u15 = call i8* malloc(8)
	%u16 = BITCAST i8* %u15 to %struct.node
	%u17 = load * %n5
	store %u16 %struct.node, %u17* 
	%u18 = call i32 (i8*, ... )*  @scanf(i8* getelementptr inbounds ([4xi8]*@.scanf,i32 0, i32 0), i32 %_scanned)
	%u19 = load i32* %_scanned
	%u20 = load %struct.node* %n0
	%u21 = getelementptr %struct.node* %u20, i1 0, i32 0
	store %u19 i32, %u21* %struct.node
	%u22 = call i32 (i8*, ... )*  @scanf(i8* getelementptr inbounds ([4xi8]*@.scanf,i32 0, i32 0), i32 %_scanned)
	%u23 = load i32* %_scanned
	%u24 = load %struct.node* %n1
	%u25 = getelementptr %struct.node* %u24, i1 0, i32 0
	store %u23 i32, %u25* %struct.node
	%u26 = call i32 (i8*, ... )*  @scanf(i8* getelementptr inbounds ([4xi8]*@.scanf,i32 0, i32 0), i32 %_scanned)
	%u27 = load i32* %_scanned
	%u28 = load %struct.node* %n2
	%u29 = getelementptr %struct.node* %u28, i1 0, i32 0
	store %u27 i32, %u29* %struct.node
	%u30 = call i32 (i8*, ... )*  @scanf(i8* getelementptr inbounds ([4xi8]*@.scanf,i32 0, i32 0), i32 %_scanned)
	%u31 = load i32* %_scanned
	%u32 = load %struct.node* %n3
	%u33 = getelementptr %struct.node* %u32, i1 0, i32 0
	store %u31 i32, %u33* %struct.node
	%u34 = call i32 (i8*, ... )*  @scanf(i8* getelementptr inbounds ([4xi8]*@.scanf,i32 0, i32 0), i32 %_scanned)
	%u35 = load i32* %_scanned
	%u36 = load %struct.node* %n4
	%u37 = getelementptr %struct.node* %u36, i1 0, i32 0
	store %u35 i32, %u37* %struct.node
	%u38 = call i32 (i8*, ... )*  @scanf(i8* getelementptr inbounds ([4xi8]*@.scanf,i32 0, i32 0), i32 %_scanned)
	%u39 = load i32* %_scanned
	%u40 = load %struct.node* %n5
	%u41 = getelementptr %struct.node* %u40, i1 0, i32 0
	store %u39 i32, %u41* %struct.node
	%u42 = load %struct.node* %n1
	%u43 = load %struct.node* %n0
	%u44 = getelementptr %struct.node* %u43, i1 0, i32 1
	store %u42 %struct.node, %u44* %struct.node
	%u45 = load %struct.node* %n2
	%u46 = load %struct.node* %n1
	%u47 = getelementptr %struct.node* %u46, i1 0, i32 1
	store %u45 %struct.node, %u47* %struct.node
	%u48 = load %struct.node* %n3
	%u49 = load %struct.node* %n2
	%u50 = getelementptr %struct.node* %u49, i1 0, i32 1
	store %u48 %struct.node, %u50* %struct.node
	%u51 = load %struct.node* %n4
	%u52 = load %struct.node* %n3
	%u53 = getelementptr %struct.node* %u52, i1 0, i32 1
	store %u51 %struct.node, %u53* %struct.node
	%u54 = load %struct.node* %n5
	%u55 = load %struct.node* %n4
	%u56 = getelementptr %struct.node* %u55, i1 0, i32 1
	store %u54 %struct.node, %u56* %struct.node
	%u57 = load i1* 0
	%u58 = load %struct.node* %n5
	%u59 = getelementptr %struct.node* %u58, i1 0, i32 1
	store %u57 i1, %u59* %struct.node
buildList-1:
	%u60 = load %struct.node* %n0
	ret %u60 %struct.node
}

define i32 @multiple(%struct.node list)
{
	%i = alloca i32
	%product = alloca i32
	%cur = alloca %struct.node*
multiple1:
multiple1:
	%u0 = load * %i
	store 0 i32, %u0* 
	%u1 = load %struct.node* %list
	%u2 = load * %cur
	store %u1 %struct.node, %u2* 
	%u3 = load %struct.node* %cur
	%u4 = getelementptr %struct.node* %u3, i1 0, i32 0
	%u5 = load * %product
	store %u4 %struct.node, %u5* 
	%u6 = load %struct.node* %cur
	%u7 = getelementptr %struct.node* %u6, i1 0, i32 1
	%u8 = load * %cur
	store %u7 %struct.node, %u8* 
multiple2:
	%u9 = load i32* %i
	%u10 = icmp SLT i32 %u9, 5
	br i1 LT, label multiple4, label multiple-1
multiple3:
multiple4:
	%u11 = load i32* %product
	%u12 = load %struct.node* %cur
	%u13 = getelementptr %struct.node* %u12, i1 0, i32 0
	%u14 = MUL i32 %u11, %u13
	%u15 = load * %product
	store %u14 i32, %u15* 
	%u16 = load %struct.node* %cur
	%u17 = getelementptr %struct.node* %u16, i1 0, i32 1
	%u18 = load * %cur
	store %u17 %struct.node, %u18* 
	%u19 = load i32* %product
	%u20 = call i32 (i8*, ... )* @printf(i8* getelementptr inbounds ([4xi8]*@.println,i32 0, i32 0), i32 %u19)
	%u21 = load i32* %i
	%u22 = ADD i32 %u21, 1
	%u23 = load * %i
	store %u22 i32, %u23* 
	br label multiple2
multiple5:
multiple-1:
	%u24 = load i32* %product
	ret %u24 i32
}

define i32 @add(%struct.node list)
{
	%i = alloca i32
	%sum = alloca i32
	%cur = alloca %struct.node*
add1:
add1:
	%u0 = load * %i
	store 0 i32, %u0* 
	%u1 = load %struct.node* %list
	%u2 = load * %cur
	store %u1 %struct.node, %u2* 
	%u3 = load %struct.node* %cur
	%u4 = getelementptr %struct.node* %u3, i1 0, i32 0
	%u5 = load * %sum
	store %u4 %struct.node, %u5* 
	%u6 = load %struct.node* %cur
	%u7 = getelementptr %struct.node* %u6, i1 0, i32 1
	%u8 = load * %cur
	store %u7 %struct.node, %u8* 
add2:
	%u9 = load i32* %i
	%u10 = icmp SLT i32 %u9, 5
	br i1 LT, label add4, label add-1
add3:
add4:
	%u11 = load i32* %sum
	%u12 = load %struct.node* %cur
	%u13 = getelementptr %struct.node* %u12, i1 0, i32 0
	%u14 = ADD i32 %u11, %u13
	%u15 = load * %sum
	store %u14 i32, %u15* 
	%u16 = load %struct.node* %cur
	%u17 = getelementptr %struct.node* %u16, i1 0, i32 1
	%u18 = load * %cur
	store %u17 %struct.node, %u18* 
	%u19 = load i32* %sum
	%u20 = call i32 (i8*, ... )* @printf(i8* getelementptr inbounds ([4xi8]*@.println,i32 0, i32 0), i32 %u19)
	%u21 = load i32* %i
	%u22 = ADD i32 %u21, 1
	%u23 = load * %i
	store %u22 i32, %u23* 
	br label add2
add5:
add-1:
	%u24 = load i32* %sum
	ret %u24 i32
}

define i32 @recurseList(%struct.node list)
{
recurseList1:
recurseList1:
	%u0 = load %struct.node* %list
	%u1 = getelementptr %struct.node* %u0, i1 0, i32 1
	%u2 = load i1* 0
	%u3 = icmp EQ %struct.node %u1, %u2
	br i1 EQ, label recurseList2, label recurseList4
recurseList2:
	br label recurseList6
recurseList3:
recurseList-1:
	%u4 = load %struct.node* %list
	%u5 = getelementptr %struct.node* %u4, i1 0, i32 0
	ret %u5 %struct.node
	%u6 = load %struct.node* %list
	%u7 = getelementptr %struct.node* %u6, i1 0, i32 0
	%u8 = load %struct.node* %list
	%u9 = getelementptr %struct.node* %u8, i1 0, i32 1
	%u10 = call i32 %recurseList(%u9)
	%u11 = MUL %struct.node %u7, %u10
	ret %u11 %struct.node
recurseList6:
recurseList6:
recurseList4:
	br label recurseList6
recurseList5:
recurseList-1:
	%u4 = load %struct.node* %list
	%u5 = getelementptr %struct.node* %u4, i1 0, i32 0
	ret %u5 %struct.node
	%u6 = load %struct.node* %list
	%u7 = getelementptr %struct.node* %u6, i1 0, i32 0
	%u8 = load %struct.node* %list
	%u9 = getelementptr %struct.node* %u8, i1 0, i32 1
	%u10 = call i32 %recurseList(%u9)
	%u11 = MUL %struct.node %u7, %u10
	ret %u11 %struct.node
recurseList6:
recurseList6:
}

define i32 @main()
{
	%list = alloca %struct.node*
	%product = alloca i32
	%sum = alloca i32
	%result = alloca i32
	%bigProduct = alloca i32
	%i = alloca i32
main1:
main1:
	%u0 = load * %i
	store 0 i32, %u0* 
	%u1 = load * %bigProduct
	store 0 i32, %u1* 
	%u2 = call %struct.node %buildList()
	%u3 = load * %list
	store %u2 %struct.node, %u3* 
	%u4 = load %struct.node* %list
	%u5 = call i32 %multiple(%u4)
	%u6 = load * %product
	store %u5 i32, %u6* 
	%u7 = load %struct.node* %list
	%u8 = call i32 %add(%u7)
	%u9 = load * %sum
	store %u8 i32, %u9* 
	%u10 = load i32* %product
	%u11 = load i32* %sum
	%u12 = SDIV i32 %u11, 2
	%u13 = SUB i32 %u10, %u12
	%u14 = load * %result
	store %u13 i32, %u14* 
main2:
	%u15 = load i32* %i
	%u16 = icmp SLT i32 %u15, 2
	br i1 LT, label main4, label main-1
main3:
main4:
	%u17 = load i32* %bigProduct
	%u18 = load %struct.node* %list
	%u19 = call i32 %recurseList(%u18)
	%u20 = ADD i32 %u17, %u19
	%u21 = load * %bigProduct
	store %u20 i32, %u21* 
	%u22 = load i32* %i
	%u23 = ADD i32 %u22, 1
	%u24 = load * %i
	store %u23 i32, %u24* 
	br label main2
main5:
	%u25 = load i32* %bigProduct
	%u26 = call i32 (i8*, ... )* @printf(i8* getelementptr inbounds ([4xi8]*@.println,i32 0, i32 0), i32 %u25)
main6:
	%u27 = load i32* %bigProduct
	%u28 = icmp NE i32 %u27, 0
	br i1 NE, label main8, label main-1
main7:
main8:
	%u29 = load i32* %bigProduct
	%u30 = SUB i32 %u29, 1
	%u31 = load * %bigProduct
	store %u30 i32, %u31* 
	br label main6
main9:
	%u32 = load i32* %result
	%u33 = call i32 (i8*, ... )* @printf(i8* getelementptr inbounds ([4xi8]*@.println,i32 0, i32 0), i32 %u32)
	%u34 = load i32* %bigProduct
	%u35 = call i32 (i8*, ... )* @printf(i8* getelementptr inbounds ([4xi8]*@.println,i32 0, i32 0), i32 %u34)
main-1:
	ret 0 i32
}

declare i32 @scanf(i8*, ...)
declare i32 @printf(i8*, ...)
declare i8* @malloc(i32)
declare void @free(i8*)
@.println = private unnamed_addr constant [5 x i8] c"%ld\0A\00, align 1
@.print = private unnamed_addr constant [5 x i8] c"%ld \00, align 1
@.read = private unnamed_addr constant [4 x i8] c"%ld\00, align 1
@.read_scratch = common global i32 0, align 4
